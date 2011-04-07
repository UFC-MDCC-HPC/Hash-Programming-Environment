using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.Pintgr { 
	public interface IPintgr<I, C> : BaseIPintgr<I, C>
	where I:IInstance<C>
	where C:IClass {
	   double Frc { get; }
	}
}
