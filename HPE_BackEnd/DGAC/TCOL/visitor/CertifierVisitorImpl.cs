using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using System;
//using br.ufc.pargo.hpe.backend.DGAC.TCOL.logic;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor{



public class CertifierVisitorImpl : CertifierVisitor{

	//logic package.
		private String logicPkg = "br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic";
	

	public int visit(CertifierOrchestrationElement element) {
		int ret=CertifierConstants.NORMAL_SIGNAL;
		CertifierConsoleLogger.write("Enter visit for " + element.getOperationStr());
			CertifierConsoleLogger.write("operation " + element.getOperation());
			//this.operation = (CertifierOrchestrationOperation)Enum.Parse(typeof(CertifierOrchestrationOperation), oper);

		//first case, the workflow element. Justo go on...
			if(element.getOperationStr()=="orchestration"){
				CertifierConsoleLogger.write("operation entrei " + element.getOperation());
			foreach(CertifierOrchestrationElement child in element.getChildren()){
				/* if(child.run()==CertifierConstants.BREAK_SIGNAL)
					 hasBreak=true;*/
				ret = child.run();
				 
				}}
		else{
			//calling logic for this type of operation via reflection
			String logicFullClassName = this.logicPkg+".Logic"+element.getOperationStr();
				Console.WriteLine ("logicfullclassname " + logicFullClassName);
					//Type c = Type.GetType(logicFullClassName); 
					     
				/*Class c = 
						Class.forName(logicFullClassName);*/
				var c =  Activator.CreateInstance(null, logicFullClassName);
				AbstractCertifierElementLogic logicClass = (AbstractCertifierElementLogic)c.Unwrap ();

				//AbstractCertifierElementLogic logicClass = (AbstractCertifierElementLogic)Activator.CreateInstance(null, logicFullClassName);
				
				 ret = logicClass.logic(element);
				 CertifierConsoleLogger.write("Element "+element.getOperationStr()+" returned: " + ret);
				
			
		}

		//System.out.println("certif vis impl" + hasBreak);
		return ret;
	}

}
}