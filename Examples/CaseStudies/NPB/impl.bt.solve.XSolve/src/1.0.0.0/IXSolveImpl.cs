using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.Solve;

namespace impl.bt.solve.XSolve { 

public class IXSolveImpl<I, C, DIR, MTH> : BaseIXSolveImpl<I, C, DIR, MTH>, ISolve<I, C, DIR, MTH>
where I:IInstance_BT<C>
where C:IClass
where DIR:IX
where MTH:IBeamWarmingMethod
{

public IXSolveImpl() { 

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
						#pragma omp parallel sections
						{
							#pragma omp section
							#pragma omp parallel sections
							{
								#pragma omp section
								Back_substitute.compute();
							}
							#pragma omp section
							Solve_cell.compute();
						}
						#pragma omp section
						Shift.synchronize();
					}
					#pragma omp section
					Pack_back_sub_info.compute();
				}
				#pragma omp section
				Pack_solve_info.compute();
			}
			#pragma omp section
			Unpack_back_sub_info.compute();
		}
		#pragma omp section
		Unpack_solve_info.compute();
	}

} // end activate method 

}

}
