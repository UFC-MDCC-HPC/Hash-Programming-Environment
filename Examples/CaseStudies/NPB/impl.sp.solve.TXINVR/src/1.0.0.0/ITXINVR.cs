using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.solve.BlockDiagonalMatVecProduct;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.data.ProblemDefinition;
using common.orientation.Axis;
using common.solve.Method;


namespace impl.sp.solve.TXINVR { 

public class ITXINVR<I,C,DIR,MTH> : BaseITXINVR<I,C,DIR,MTH>, IBlockDiagonalMatVecProduct<I,C,DIR,MTH>
		where I:IInstance<C>
		where C:IClass
		where DIR:IAxis
		where MTH:IMethod
{

public ITXINVR() 
{ 
    initialize();
} 

private int[,] start, end, cell_size;
private double[,,,,] rhs, rho_i, us, vs, ws, qs, speed, ainv;
private double bt, c2;
private int ncells;
		
public void initialize() 
{
	start = Blocks.cell_start;
	end = Blocks.cell_end;
	cell_size = Blocks.cell_size;
			
	rhs = Problem.Field_rhs;
	rho_i = Problem.Field_rho;
	us = Problem.Field_us;
	vs = Problem.Field_vs;
	ws = Problem.Field_ws;
	qs = Problem.Field_qs;
	speed = Problem.Field_speed;
	ainv = Problem.Field_ainv;
			
			
	bt = Constants.bt;
	c2 = Constants.c2;
			
	ncells = Problem.NCells;
			
}
		
					
public void enterStage(int stage)			
{
}
		

		
public override void compute() { 
    int c, i, j, k, isize, jsize, ksize;
    double t1, t2, t3, ac, ru1, xvel, yvel, zvel,
           r1, r2, r3, r4, r5, ac2inv;
    
    for (c = 0; c < ncells; c++)
    {
        ksize = cell_size[c, 2] + 2;
        jsize = cell_size[c, 1] + 2;
        isize = cell_size[c, 0] + 2;

        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
        {
            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
            {
                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                {
                    ru1 = rho_i[c, k, j, i, 0];
                    xvel = us[c, k, j, i, 0];
                    yvel = vs[c, k, j, i, 0];
                    zvel = ws[c, k, j, i, 0];
                    ac = speed[c, k, j, i, 0];
                    ac2inv = ainv[c, k, j, i, 0] * ainv[c, k, j, i, 0];

                    r1 = rhs[c, k, j, i, 0];
                    r2 = rhs[c, k, j, i, 1];
                    r3 = rhs[c, k, j, i, 2];
                    r4 = rhs[c, k, j, i, 3];
                    r5 = rhs[c, k, j, i, 4];
                        
                    t1 = c2 * ac2inv * (qs[c, k, j, i, 0] * r1 - xvel * r2 -
                        yvel * r3 - zvel * r4 + r5);
                    t2 = bt * ru1 * (xvel * r1 - r2);
                    t3 = (bt * ru1 * ac) * t1;

                    rhs[c, k, j, i, 0] = r1 - t1;
                    rhs[c, k, j, i, 1] = -ru1 * (zvel * r1 - r4);
                    rhs[c, k, j, i, 2] = ru1 * (yvel * r1 - r3);
                    rhs[c, k, j, i, 3] = -t2 + t3;
                    rhs[c, k, j, i, 4] = t2 + t3;
                }
            }
        }
    }

} // end activate method 

}

}
