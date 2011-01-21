using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.Verify;

namespace impl.common.VerifyImpl { 

public class IVerifyImpl : BaseIVerifyImpl, IVerify
{

public IVerifyImpl() { 

} 

public override void compute() { 
	#pragma omp parallel sections
	{
		#pragma omp section
		rhs_norm.compute();
		#pragma omp section
		error_norm.compute();
	}

} // end activate method 

}

}
