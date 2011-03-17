using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.orientation.Y;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using bt.solve.BeamWarmingMethod;
using bt.solve.Solve;

namespace impl.bt.solve.YSolve { 

public class IYSolveImpl<DIR, I, C, MTH> : BaseIYSolveImpl<DIR, I, C, MTH>, ISolve<DIR, I, C, MTH>
where DIR:IY
where I:IInstance_BT<C>
where C:IClass
where MTH:IBeamWarmingMethod
{

public IYSolveImpl() { 

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
								solve_cell.compute();
							}
							#pragma omp section
							shift.synchronize();
						}
						#pragma omp section
						back_substitute.compute();
					}
					#pragma omp section
					packunpack.compute();
				}
				#pragma omp section
				null.compute();
			}
			#pragma omp section
			null.compute();
		}
		#pragma omp section
		null.compute();
	}

} // end activate method 

}

}
