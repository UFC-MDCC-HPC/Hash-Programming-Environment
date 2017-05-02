using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic;
using System;
using ExpressionEvaluator;
using br.ufc.pargo.hpe.kinds;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic{


public class LogicSwitchOper : AbstractCertifierElementLogic{

		public override int logic(CertifierOrchestrationElement element) {
		int ret=CertifierConstants.NORMAL_SIGNAL;
		CertifierConsoleLogger.write("STARTING SWITCH TASK");
		
	//ChoiceOperComplexType choice_oper = (ChoiceOperComplexType)element.getElement();
		
		
		for(int i=element.getChildren().Count-1;i>=0;i--){
			CertifierOrchestrationElement select = element.getChildren()[i];
			//System.out.println("Size " + element.getChildren().Count);
				switchoperComplexTypeChoice choice_oper = (switchoperComplexTypeChoice)select.getElement();
			
				String condition = choice_oper.condition;
			CertifierConsoleLogger.write("Condition: " + condition);
			//navegar no select
			
			
			
			
		    //Integer x = 0;
		    //String teste = "x == 0";
		    //Certifier.variablesTryAdd(x,x);	
		    
		   // System.out.println(x.toString());
			condition.Replace("&lt;", "<");
			condition.Replace("&gt;", ">");
			condition.Replace("&quot;", "\"");
			condition.Replace("&amp;", "&");
			condition.Replace("&apos;", "\'");
				/*if (Certifier.formal_properties.get ("mProjExecMPI1", "no deadlock")) {

					Console.WriteLine ("no deadlock true");
				}*/

				//reg.Add.RegisterType ("C4Impl", C4Impl);
				var p = new CompiledExpression(condition) { TypeRegistry = Certifier.variables };
				//p.Parse();
				p.Compile();
				//Console.WriteLine("Result: {0}", p.Eval());
		        
				CertifierConsoleLogger.write("Condition evaluated: " + p.Eval());
		    
			
			
			//System.out.println(cond.booleanValue());
			//System.out.println("Proved vc percent: "  + Certifier.provedVCPercent);
				if((bool)p.Eval()){
			
			//if(true)){
				CertifierOrchestrationElement child = select.getChildren()[0];
						
				ret = child.run();
				//System.out.println("select" + ret);
				
			    break;
			}
			
				
					
				
			
		}
		CertifierConsoleLogger.write("ENDED SWITCH TASK");
		
		
		
		return ret;
		
		}
	
	
		
	}

}
