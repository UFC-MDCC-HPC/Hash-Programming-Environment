using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using bt.ADI;

namespace impl.bt.ADI { 

public class IADIImpl<C> : BaseIADIImpl<C>, IADI<C>
where C:IClass
{

public IADIImpl() { 

} 

public override void compute() { 
	#pragma omp parallel sections
	{
		#pragma omp section
		solve.compute();
		#pragma omp section
		null.compute();
		#pragma omp section
		null.compute();
		#pragma omp section
		compute_rhs.compute();
		#pragma omp section
		add.compute();
		#pragma omp section
		copy_faces.synchronize();
	}

} // end activate method 

}

}
