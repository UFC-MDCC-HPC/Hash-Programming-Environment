using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.BT;

namespace impl.bt.BT { 

public class IBTImpl<IClass> : BaseIBTImpl<IClass>, IBT<IClass>
{

public IBTImpl() { 

} 

public override void compute() { 
	#pragma omp parallel sections
	{
		#pragma omp section
		#pragma omp parallel sections
		{
			#pragma omp section
			lhsinit.compute();
			#pragma omp section
			initialize.compute();
			#pragma omp section
			exact_rhs.compute();
			#pragma omp section
			verify.compute();
		}
		#pragma omp section
		adi.compute();
	}

} // end activate method 

}

}
