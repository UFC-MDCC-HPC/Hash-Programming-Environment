using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor{



public interface CertifierVisitor {

	 int visit(CertifierOrchestrationElement element);
}

}
