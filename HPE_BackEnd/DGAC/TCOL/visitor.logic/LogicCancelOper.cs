using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic;
using System;
using br.ufc.pargo.hpe.kinds;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic{



/**
 * Implements the logic for CANCEL operation.
 * [cancel]
 *  |
 *  |---handle_id(?)---|--instantiate [comp_id]
 *  				   |--prove [action_id]
 *  
 * @author allberson
 *
 */
public class LogicCancelOper : AbstractCertifierElementLogic{

	
		public override int logic(CertifierOrchestrationElement element) {
		String handle_id = null;
			String port_id = null;
		String action_id = null; // action_id or component_id
		String action_oper = null;
	    string comp_id = null;
		
			if( typeof(XMLCertifierPrimOper).IsInstanceOfType(element.getElement())){
			XMLCertifierPrimOper cancel_oper = (XMLCertifierPrimOper)element.getElement();
			handle_id = cancel_oper.handle_id;
		}
		
		
		for(int i=element.getChildren().Count-1;i>=0;i--){
			CertifierOrchestrationElement child = element.getChildren()[i];
				if(typeof(XMLCertifierAction).IsInstanceOfType(child.getElement())){
				XMLCertifierAction safe_action = (XMLCertifierAction)child.getElement();
					port_id = safe_action.port_id;
					action_id = safe_action.action_id;
					action_oper = safe_action.oper_name;

//					action_oper = safe_action.getAction().value();
					comp_id=safe_action.comp_id;
			}
		}

		if (action_oper.Equals("instantiate")) {
				this.instantiateOper(handle_id);
		} else if (action_oper.Equals("compute")) {
				this.computeOper(handle_id);
		} //else if (action_oper.Equals("compute")) {
		//	this.computeOper(subject_id);
		//}
		return CertifierConstants.NORMAL_SIGNAL;
	}
	
		private void instantiateOper(String handle_id) {

		/*ArchComponent archComponent = HPCStormObjectRepository
				.getWorkflowEngine().getArchComponentByID(
						Integer.parseInt(compId));
		System.out.println("ACTION: " + archComponent);*/
		
			CertifierConsoleLogger.write("cancel instantiate ==> "+ "handle_id " + handle_id);
		
		LogicActionInstantiate l=null;
			if(!Certifier.InstantiateActions.ContainsKey(handle_id)){
				CertifierConsoleLogger.write("Fatal Error: Cancelling inexistent handle_id: handle_id  " + handle_id);
				System.Environment.Exit(0);
		}else{
				l= (LogicActionInstantiate)Certifier.InstantiateActions[handle_id];
			
		}
		 
		
		l._thread.Interrupt();
		
		
	}

/*	private void resolveOper(String compId) {

		ArchComponent archComponent = HPCStormObjectRepository
				.getWorkflowEngine().getArchComponentByID(
						Integer.parseInt(compId));
		System.out.println("ACTION: " + archComponent);

	}*/

		private void computeOper(String handle_id) {
		/*ArchAction archAction = HPCStormObjectRepository.getWorkflowEngine()
				.getArchActionId(Integer.parseInt(actionId));
		System.out.println("ACTION: " + archAction);*/
			CertifierConsoleLogger.write("cancel compute "+ "handle_id " + handle_id );
		
		
		LogicActionCompute l=null;
			if(!Certifier.ComputeActions.ContainsKey(handle_id)){
				CertifierConsoleLogger.write("Fatal Error: Cancelling inexistent handle_id: handle_id  " + handle_id );
				System.Environment.Exit(0);
		}else{
				l= (LogicActionCompute)Certifier.ComputeActions[handle_id];
			
		}
		 
		
		l._thread.Interrupt();
	}
}
}