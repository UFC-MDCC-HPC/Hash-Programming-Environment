using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.datapartition.Blocks3D { 

public interface IBlocks3D<I, C> : BaseIBlocks3D<I, C>
where I:IInstance<C>
where C:IClass
{


} // end main interface 

} // end namespace 
