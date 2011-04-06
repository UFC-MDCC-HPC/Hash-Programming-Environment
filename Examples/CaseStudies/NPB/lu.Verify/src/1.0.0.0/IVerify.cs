using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.Verify { 
	public interface IVerify<I, C> : BaseIVerify<I, C>
	where I:IInstance<C>
	where C:IClass {
	   int Verified { get; }
	   void setParameters(double[] xcr, double[] xce, double xci);
	}
}
