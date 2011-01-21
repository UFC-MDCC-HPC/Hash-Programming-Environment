using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using br.ufc.lia.pargo.hpe.casestudies.npb.SP;

namespace impl.sp.SP { 

public class ISPImpl : BaseISPImpl, ISP
{

public ISPImpl() { 

} 

public override void compute() { 
	#pragma omp parallel sections
	{
		#pragma omp section
		#pragma omp parallel sections
		{
			#pragma omp section
			#pragma omp section
			#pragma omp section
			#pragma omp section
			adi.compute();
		}
		#pragma omp section
		verify.compute();
	}

} // end activate method 

}

}
