using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic;
using System;
using br.ufc.pargo.hpe.kinds;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic{

public class LogicSequenceOper : AbstractCertifierElementLogic{

	public override int logic(CertifierOrchestrationElement element) {
		int ret=CertifierConstants.NORMAL_SIGNAL;
		CertifierConsoleLogger.write("STARTING SEQUENCE TASKS");

		for(int i=element.getChildren().Count-1;i>=0;i--){
			CertifierOrchestrationElement child = element.getChildren()[i];
			ret = child.run();
			if(ret>CertifierConstants.NORMAL_SIGNAL){ /*=CertifierConstants.BREAK_SIGNAL ||
					ret==CertifierConstants.CONTINUE_SIGNAL ||ret==CertifierConstants.RETURN_CERTIFIED ||ret==CertifierConstants.RETURN_NOT_CERTIFIED){
				*/
					CertifierConsoleLogger.write("Signal found: " + ret + ". Stopping sequence execution.");
				break;
				
			}
		}
		CertifierConsoleLogger.write("ENDED SEQUENCE TASKS");
	return ret;
	}

}
}