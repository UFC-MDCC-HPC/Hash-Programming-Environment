using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;

namespace bt.solve.LhsABInit { 

public interface ILhsABInit<I, C> : BaseILhsABInit<I, C>
where I:IInstance_BT<C>
where C:IClass
{


} // end main interface 

} // end namespace 
