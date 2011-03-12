using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace bt.problem_size.Instance_BT { 

public interface IInstance_BT<C> : BaseIInstance_BT<C>, IInstance<C>
        where C:IClass
{
		double[] xcrref { get; }
		double[] xceref { get; }
		double dtref { get; }	

} // end main interface 

} // end namespace 
