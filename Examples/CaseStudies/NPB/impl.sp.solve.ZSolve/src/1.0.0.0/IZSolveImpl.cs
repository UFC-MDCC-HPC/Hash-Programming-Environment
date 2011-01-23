using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.solve.Solve;

namespace impl.sp.solve.ZSolve { 

public class IZSolveImpl : BaseIZSolveImpl, ISolve
{

public IZSolveImpl() { 

} 

public override void compute() { 
	#pragma omp parallel sections
	{
		#pragma omp section
		forward.compute();
		#pragma omp section
		lhs.compute();
		#pragma omp section
		matvecproduct.compute();
		#pragma omp section
		backward.compute();
		#pragma omp section
		shift.synchronize();
	}

} // end activate method 

}

}