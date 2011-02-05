using br.ufc.pargo.hpe.kinds;

namespace common.data.ExactSolution { 

public interface IExactSolution : BaseIExactSolution
{

   void initialize();
   void setParameters(double xi, double eta, double zeta, double[] dtemp, int offset);

} // end main interface 

} // end namespace 
