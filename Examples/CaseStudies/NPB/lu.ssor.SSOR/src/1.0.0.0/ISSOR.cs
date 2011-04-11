using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.ssor.SSOR { 
	public interface ISSOR<I, C> : BaseISSOR<I, C>
	where I:IInstance<C>
	where C:IClass{
	   double[] Rsdnm { get; }
	   double Maxtime { get; }
	   void setParameters(int niter);
	}
}
