using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;
using bt.solve.Method;

namespace bt.solve.BlockDiagonalMatVecProduct { 

public interface IBlockDiagonalMatVecProduct<I, C, DIR, MTH> : BaseIBlockDiagonalMatVecProduct<I, C, DIR, MTH>
where I:IInstance<C>
where C:IClass
where DIR:IAxis
where MTH:IMethod
{


} // end main interface 

} // end namespace 
