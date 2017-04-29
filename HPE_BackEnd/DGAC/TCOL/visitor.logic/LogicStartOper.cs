using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic;
using System;
using br.ufc.pargo.hpe.kinds;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic{

/**
 * Implements the logic for START operation.
 * [start]
 *  |
 *  |---handle_id(?)---|--instantiate [comp_id]
 *  				   |--compute [comp_id action_id]
 *  
 * @author allberson
 *
 */
public class LogicStartOper : AbstractCertifierElementLogic{
	
		public override int logic(CertifierOrchestrationElement element) {
		
		String handle_id = null;
			String port_id = null;
			String action_id = null;

		String  comp_id = null; //action_id or component_id
		String action_oper = null;
		
			if( typeof( XMLCertifierPrimOper).IsInstanceOfType(element.getElement())){
			XMLCertifierPrimOper start_oper = (XMLCertifierPrimOper)element.getElement();
			handle_id = start_oper.handle_id;
		}
		
		
		for(int i=element.getChildren().Count-1;i>=0;i--){
			CertifierOrchestrationElement child = element.getChildren()[i];
				if( typeof(XMLCertifierAction).IsInstanceOfType(child.getElement())){
				XMLCertifierAction certifier_action = (XMLCertifierAction)child.getElement();
					comp_id = certifier_action.comp_id;
					port_id = certifier_action.port_id;
					action_id = certifier_action.action_id;
					//action_oper = certifier_action..value();
					action_oper = certifier_action.action.ToString();
			}
		}
		
		if(action_oper.Equals("instantiate")){
				this.instantiateOper(comp_id,handle_id);
		}else if(action_oper.Equals("compute")){
				this.computeOper(comp_id, port_id, action_id,handle_id);
		}/*else if(action_oper.Equals("compute")){
			this.computeOper(subject_id);
		}*/
		return CertifierConstants.NORMAL_SIGNAL;
	}
	
		private void instantiateOper(String compId,string handle_id){
		
		/*ArchComponent archComponent = HPCStormObjectRepository.getWorkflowEngine().getArchComponentByID(Integer.parseInt(compId));
		System.out.println("start instantiate=> archComponent: ["+archComponent.getId()+"]" + archComponent.getName());
	*/
			CertifierConsoleLogger.write("start instantiate => " + "CompID " + compId + " handleid informed " + handle_id);
		
		LogicActionInstantiate l;
			if(!Certifier.InstantiateActions.ContainsKey(handle_id)){
			
			//if (compId.Equals("1")){// call alt-ergo
				l =  new LogicActionInstantiate(compId,handle_id);
			//else{// call z3
				
		//		l =  new LogicActionInstantiate(compId, Certifier.tacticalCommand2);
	//		}
			
			
				Certifier.InstantiateActions.TryAdd(handle_id, l);
			
		}else{
			
				l= (LogicActionInstantiate)Certifier.InstantiateActions[handle_id];
		
				CertifierConsoleLogger.write("HandleId already exists. Waiting for respective action to finish in order to create a new one.");
				l._thread.Join();
				CertifierConsoleLogger.write("Previous action finished! Creating a new one.");
				
				
	//			if (compId.Equals("1")){// call alt-ergo
				l =  new LogicActionInstantiate(compId,handle_id);
	//				else{// call z3
						
	//					l =  new LogicActionInstantiate(compId, Certifier.tacticalCommand2);
	//				}
				
				Certifier.InstantiateActions.TryUpdate(handle_id, l, Certifier.InstantiateActions[handle_id]);
				
		
			
		}
		

			l.start();
		
		
		//System.out.println("ACTION! " + "instantiate "+ compId);
	}
	
	/*private void resolveOper(String compId){
		
		ArchComponent archComponent = HPCStormObjectRepository.getWorkflowEngine().getArchComponentByID(Integer.parseInt(compId));
		System.out.println("start resolve=> archComponent: ["+archComponent.getId()+"]" + archComponent.getName());

	}*/
	
		private void computeOper(String compId, string port_id, string action_id, string handle_id){
	/*	ArchAction archAction = HPCStormObjectRepository.getWorkflowEngine().getArchActionId(Integer.parseInt(actionId));
		System.out.println("start compute=> archAction: ["+archAction.getId()+"]" + archAction.getName());
	*/
			CertifierConsoleLogger.write("start compute => " + " CompID " + compId + " portid " + port_id + "actionId " + action_id);
		
		
		LogicActionCompute l;
		if(!Certifier.ComputeActions.ContainsKey(compId)){
			
			//if (compId.Equals("1")){// call alt-ergo
				l =  new LogicActionCompute(compId, port_id, action_id,handle_id);
			//else{// call z3
				
		//			l =  new LogicActionCompute(compId, action_id, Certifier.tacticalCommand2);
		//	}
			
		
			Certifier.ComputeActions.TryAdd(compId, l);
			
		}else{
			
			l= (LogicActionCompute)Certifier.ComputeActions[compId];
			
				CertifierConsoleLogger.write("Action already exists. Waiting for it to finish in order to create a new one.");
				l._thread.Join();
				CertifierConsoleLogger.write("Previous action finished! Creating a new one.");
				
				
			//	if (compId.Equals("1")){ // call alt-ergo
				l =  new LogicActionCompute(compId, port_id, action_id,handle_id);
			//		else{// call z3
						
			//			l =  new LogicActionCompute(compId, action_id, Certifier.tacticalCommand2);
			//		}
				
					Certifier.ComputeActions.TryUpdate(compId, l,Certifier.ComputeActions[compId]);
					
				
		
			
		}
		

			l.start();
		

		
		
		
		/*TacticInvoker ti = new TacticInvoker(Certifier.tacticalCommand);
		Thread t = new Thread(ti);
		t.start();*/
		/*try {
			t.Join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*TacticInvoker t1 = new TacticInvoker(Certifier.tacticalCommand);
		t1.start();*/
		//System.out.println("ACTION! " + "prove "+ actionId);
	}
	

	}}
