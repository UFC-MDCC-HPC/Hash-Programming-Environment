using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.error.ErrorNorm;

namespace impl.common.error.ErrorNormImpl { 

public class IErrorNormImpl : BaseIErrorNormImpl, IErrorNorm
{

public IErrorNormImpl() { 

} 

public override void compute() { 
	#pragma omp parallel sections
	{
		#pragma omp section
	}

} // end activate method 

}

}
