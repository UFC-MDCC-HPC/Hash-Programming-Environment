using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.datapartition.Blocks { 

public interface IBlocks<I, C> : BaseIBlocks<I, C>
where I:IInstance<C>
where C:IClass
{


} // end main interface 

} // end namespace 
