using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using common.problem_size.Instance;

namespace common.datapartition.Blocks3D { 

public interface IBlocks3D<I,C> : BaseIBlocks3D<I,C>
		where I:IInstance<C>
		where C:IClass
{

} // end main interface 

} // end namespace 
