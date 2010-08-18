using hpe.kinds;
using linearsystems.application.MatrixType;
using linearsystems.application.MatrixFormat;
using linearsystems.application.SolutionMethod;

namespace linearsystems.application.Matrix { 

public interface IMatrix<MT, MF, SM> : BaseIMatrix<MT, MF, SM>
where MT:IMatrixType
where MF:IMatrixFormat<MT>
where SM:ISolutionMethod<MT>
{


} // end main interface 

} // end namespace 
