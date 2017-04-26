using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using System;

namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic{



public class LogicBreakOper : AbstractCertifierElementLogic{

	
		public  override int logic(CertifierOrchestrationElement element) {
		Console.WriteLine("BREAK OPERATION");
		return CertifierConstants.BREAK_SIGNAL;
		
		//Certifier.BreakIterate = true;
		
		
	}

}
}