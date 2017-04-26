using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic;
using System;
using br.ufc.pargo.hpe.kinds;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic{

public class LogicParallelOper : AbstractCertifierElementLogic{
	bool hasBreakOrContinue=false; int ret;
		public override int logic(CertifierOrchestrationElement element) {
		
		ParallelJob[] threads = new ParallelJob[element.getChildren().Count];
		
		//creating threads
		for(int i=element.getChildren().Count-1, j=0;i>=0;i--,j++){
			CertifierOrchestrationElement child = element.getChildren()[i];
			ParallelJob pj = new ParallelJob(child);
			threads[j] = pj;
		}
		
		//starting threads
		CertifierConsoleLogger.write("STARTING PARALLEL TASK");
		foreach(ParallelJob job in threads){
			job.run();
		
		}
			
		
		//join threads
		foreach(ParallelJob job in threads){
			
				
				if(!hasBreakOrContinue){
				job._thread.Join();
				ret = job.ret;
					Console.WriteLine (" parallel job. return of job " + ret);
					if(ret > CertifierConstants.NORMAL_SIGNAL ){//== CertifierConstants.BREAK_SIGNAL || ret == CertifierConstants.CONTINUE_SIGNAL || ret == CertifierConstants.RETURN_CERTIFIED||ret == CertifierConstants.RETURN_NOT_CERTIFIED ){
					
						hasBreakOrContinue=true;
						//break;
					}
					
				}else{
					CertifierConsoleLogger.write("Signal found in parallel tasks: "+ ret + ". Interrupting all the remaining threads.");
					job._thread.Interrupt();
					
				}
				
			
		}
		CertifierConsoleLogger.write("ENDED PARALLEL TASK");
		
		return ret;
		
	}

}


}
