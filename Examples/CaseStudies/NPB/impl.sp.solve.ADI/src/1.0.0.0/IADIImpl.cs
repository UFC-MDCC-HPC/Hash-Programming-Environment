using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.ADI;

namespace impl.sp.solve.ADI { 

public class IADIImpl : BaseIADIImpl, IADI
{

public IADIImpl() { 

} 

public override void compute() { 
	#pragma omp parallel sections
	{
		#pragma omp section
		#pragma omp parallel sections
		{
			#pragma omp section
			#pragma omp parallel sections
			{
				#pragma omp section
				#pragma omp parallel sections
				{
					#pragma omp section
					#pragma omp parallel sections
					{
						#pragma omp section
						z_solve.compute();
						#pragma omp section
						null.compute();
						#pragma omp section
						null.compute();
					}
					#pragma omp section
					copy_faces.synchronize();
				}
				#pragma omp section
				compute_rhs.compute();
			}
			#pragma omp section
			add.compute();
		}
		#pragma omp section
		txinvr.compute();
	}

} // end activate method 

}

}
