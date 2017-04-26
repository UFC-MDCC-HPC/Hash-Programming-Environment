using System;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar{
public class CertifierOrchestrationParser {

	private CertifierOrchestration certifierOrchestration;
	
	public void readOrchestrationXML(String fileName){
		this.certifierOrchestration = new CertifierOrchestration(fileName);	
	}

	public CertifierOrchestration getOrchestration() {
		return certifierOrchestration;
	}
	
	
	}}
