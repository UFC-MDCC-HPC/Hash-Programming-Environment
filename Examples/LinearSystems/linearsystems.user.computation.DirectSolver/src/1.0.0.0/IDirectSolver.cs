using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;
using linearsystems.user.qualifier.ElementDataType;
using linearsystems.user.data.Matrix;
using linearsystems.user.data.Vector;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.qualifier.SolutionMethod;
using linearsystems.user.computation.Solver;
using environment.messagepassing.Communicator;

namespace linearsystems.user.computation.DirectSolver { 

public interface IDirectSolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, COM> : BaseIDirectSolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, COM>, ISolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, COM>
where LIB:ILibrary
where MPT:IMatrixProperty<LIB>
where NUM:IElementDataType
where MAT:IMatrix<LIB, MPT, NUM>
where VEC:IVector<LIB, NUM>
where PRC:IPreConditioner<LIB, MPT>
where MTH:ISolutionMethod<PRC, MPT, LIB>
where COM:ICommunicator
{


} // end main interface 

} // end namespace 
