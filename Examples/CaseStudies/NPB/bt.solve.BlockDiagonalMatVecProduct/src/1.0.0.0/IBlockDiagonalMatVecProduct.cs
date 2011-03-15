using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.Method;

namespace bt.solve.BlockDiagonalMatVecProduct { 

public interface IBlockDiagonalMatVecProduct<I, C, MTH> : BaseIBlockDiagonalMatVecProduct<I, C, MTH>
where I:IInstance<C>
where C:IClass
where MTH:IMethod
{


} // end main interface 

} // end namespace 
