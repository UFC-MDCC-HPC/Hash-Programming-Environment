using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.error.RHSNorm;
using common.problem_size.Class;
using common.problem_size.Instance;
using MPI;

namespace impl.common.error.RHSNormImpl { 

public class IRHSNormImpl<I,C> : BaseIRHSNormImpl<I,C>, IRHSNorm<I,C>
		where I:IInstance<C>
		where C:IClass
{

	public IRHSNormImpl() 
	{ 
			initialize();
	} 
		
    private int[,] cell_size, start, end;		
	private int ncells;
	private double[,,,,] rhs;
	private int[] grid_points;
	private Intracommunicator comm_setup;
		
	public void initialize() 
	{
		cell_size = Blocks.cell_size;
        start = Blocks.cell_start;
		end = Blocks.cell_end;
			
		ncells = Problem.NCells;
		rhs = Problem.Field_rhs;
			
		rms = new double[5];
			
		grid_points = Problem.grid_points;
			
		comm_setup = Mpi.localComm(this);
	}
	
	private double[] rms; 
		
	public double[] xcr { get { return rms; } }
		
	public override void compute() { 
		
            int c, i, j, k, d, m, ksize, jsize, isize;
            double add;
            double[] rms_work = new double[5];

            for (m = 0; m < 5; m++)
            {
                rms_work[m] = 0.0d;
            }

            for (c = 0; c < ncells; c++)
            {
                ksize = cell_size[c, 2] + 2;
                jsize = cell_size[c, 1] + 2;
                isize = cell_size[c, 0] + 2;

                for (m = 0; m < 5; m++)
                {
                    for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                    {
                        for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                        {
                            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                            {
                                add = rhs[c, k, j, i, m];
                                rms_work[m] += add * add;
                            }
                        }
                    }
                }
            }

			comm_setup.Allreduce<double>(rms_work, Operation<double>.Add, ref rms);


            for (m = 0; m < 5; m++)
            {
                for (d = 0; d < 3; d++)
                {
                    rms[m] = rms[m] / (grid_points[d] - 2);
                }
                rms[m] = Math.Sqrt(rms[m]);
            }
	
	} 

}

}
