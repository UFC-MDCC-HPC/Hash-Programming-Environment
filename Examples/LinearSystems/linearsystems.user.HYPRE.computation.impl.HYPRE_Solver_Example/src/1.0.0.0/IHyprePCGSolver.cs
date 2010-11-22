using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.SparseMatrix;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.qualifier.ConjugateGradient;
using linearsystems.user.computation.Solver;

namespace linearsystems.user.HYPRE.computation.impl.HYPRE_Solver_Example { 

public class IHyprePCGSolver<LIB, MPT, PRC, MTH> : BaseIHyprePCGSolver<LIB, MPT, PRC, MTH>, ISolver<LIB, MPT, PRC, MTH>
where LIB:IHYPRE
where MPT:ISparseMatrix<LIB>
where PRC:IPreConditioner<LIB, MPT>
where MTH:IConjugateGradient<LIB, MPT, PRC>
{

public IHyprePCGSolver() { 

} 

public override void compute() { 
	;

} // end activate method 

}

}
