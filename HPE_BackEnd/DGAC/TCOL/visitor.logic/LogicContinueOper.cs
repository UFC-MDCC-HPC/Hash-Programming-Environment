using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor;
using  br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic{



public class LogicContinueOper : AbstractCertifierElementLogic{

		public override int logic(CertifierOrchestrationElement element) {
		CertifierConsoleLogger.write("CONTINUE OPERATION");
		return CertifierConstants.CONTINUE_SIGNAL;
		
		//Certifier.BreakIterate = true;
		
		
	}

}
}