using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.solve.Solve;

namespace impl.sp.solve.XSolve { 

public class IXSolveImpl : BaseIXSolveImpl, ISolve
{

public IXSolveImpl() { 

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
