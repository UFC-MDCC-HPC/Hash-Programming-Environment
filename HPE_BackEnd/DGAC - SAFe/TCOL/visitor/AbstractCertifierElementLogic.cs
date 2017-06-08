using System.Collections.Generic;
using System.Collections;
using System;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor {




public abstract class AbstractCertifierElementLogic {

	private  IDictionary<String, Object> variables;
	
	public AbstractCertifierElementLogic() {
		this.variables = new Dictionary<String, Object>();
	}
	
	public abstract int logic(CertifierOrchestrationElement element);
	 
	public void addVariable(String name, Object value){
		this.variables.Add(name, value);
	}
	
	public Object getVariable(String name){
			Object ret;
		 this.variables.TryGetValue(name, out ret);
			return ret;
		}
}
}