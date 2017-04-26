using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic;
using System;
using br.ufc.pargo.hpe.kinds;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic{

public class LogicRepeatOper : AbstractCertifierElementLogic {

		public override int logic(CertifierOrchestrationElement element) {

		int max = -1, ret = CertifierConstants.NORMAL_SIGNAL; 

			if ( typeof(RepeatOper).IsInstanceOfType(element.getElement())) {
			RepeatOper iterate_oper = (RepeatOper) element.getElement();
			// every children must run MAX
			max = iterate_oper.getMax();
		}

		
		
		children:
		for (int i = 0; i < max; i++){
			// inside children
			
			for (int j = element.getChildren().Count - 1; j >= 0; j--) {
				CertifierOrchestrationElement child = element.getChildren()[j];
				/*if(child.getOperation().Equals(CertifierOrchestrationOperation.BREAKOPER)){
					break children;
				}else if(child.getOperation().Equals(CertifierOrchestrationOperation.CONTINUEOPER)){
					continue children;
				}*/
				 ret =child.run() ;
				if( ret == CertifierConstants.BREAK_SIGNAL){
					CertifierConsoleLogger.write("BREAK Operation was found. Breaking inner iterate.");
					goto _break;
					
					
				}
				if( ret == CertifierConstants.CONTINUE_SIGNAL){
					CertifierConsoleLogger.write("CONTINUE Operation was found. Going back to the beginning of iterate.");
					
					goto children;
					
					
				}
				/*if( ret == CertifierConstants.RETURN_CERTIFIED_SIGNAL || ret == CertifierConstants.RETURN_NOT_CERTIFIED_SIGNAL){
					CertifierConsoleLogger.write("RETURN Operation was found. Stopping certification process and returning.");
					
					return ret;
					
					
				}*/
				
				
				
				
			}
			
		}

		
		_break: return CertifierConstants.NORMAL_SIGNAL;
	}
	}}
