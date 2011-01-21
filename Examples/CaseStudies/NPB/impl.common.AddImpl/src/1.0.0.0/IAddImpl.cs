using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.Add;

namespace impl.common.AddImpl { 

public class IAddImpl : BaseIAddImpl, IAdd
{

public IAddImpl() { 

} 

private int ncells;
private double[,,,,] u;
private double[,,,,] rhs;
private int[,] start;
private int[,] end;
private int[,] cell_size;

public void inititialize() 
{  	
    ncells = Problem.NCells;			
	u = Problem.Field_u;
	rhs = Problem.Field_rhs;
	start = Blocks.cell_start;
	end = Blocks.cell_end;
	cell_size = Blocks.cell_size;   
}

public override void compute() 
{ 			
    int c, i, j, k, m;

    for (c = 0; c < ncells; c++)
    {
        for (k = start[c, 2]; k < 2 + cell_size[c, 2] - end[c, 2]; k++)
        {
            for (j = start[c, 1]; j < 2 + cell_size[c, 1] - end[c, 1]; j++)
            {
                for (i = start[c, 0]; i < 2 + cell_size[c, 0] - end[c, 0]; i++)
                {
                    for (m = 0; m < 5; m++)
                    {
                        u[c, k, j, i, m] += rhs[c, k, j, i, m];
                    }
                }
            }
        }
    }

} // end activate method 

}

}
