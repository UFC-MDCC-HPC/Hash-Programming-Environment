/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.data.ExactSolution;
using common.data.ExactRHS;

namespace impl.sp.data.ExactRHSImpl { 

public abstract class BaseIExactRHSImpl<I, C>: Computation, BaseIExactRHS<I, C>
where I:IInstance_SP<C>
where C:IClass
{
		
#region data
		
protected int[,] cell_size, cell_low, start, end;		
protected int ncells;		
protected double[,,,,] forcing;		
protected double[,] ue, buf;
protected double[] cuf, q;		
protected double dnzm1, dnym1, dnxm1, c1, c2, dssp, 
               tx2, dx1tx1, xxcon1, dx2tx1, xxcon2, dx3tx1, dx4tx1, xxcon3, xxcon4, xxcon5, dx5tx1, 
			   ty2, dy1ty1, yycon2, dy2ty1, yycon1, dy3ty1, dy4ty1, yycon3, yycon4, yycon5, dy5ty1,
			   tz2, dz1tz1, zzcon2, dz2tz1, zzcon1, dz3tz1, dz4tz1, zzcon3, zzcon4, zzcon5, dz5tz1;
		
override public void initialize()
{
	cell_size = Blocks.cell_size;
	cell_low = Blocks.cell_low;
	start = Blocks.cell_start;
	end = Blocks.cell_end;
	
	int MAX_CELL_DIM = Problem.MAX_CELL_DIM;
	
	ue = new double[MAX_CELL_DIM + 4, 5];  
    buf = new double[MAX_CELL_DIM + 4, 5]; 
	cuf = new double[MAX_CELL_DIM + 4];    
	q = new double[MAX_CELL_DIM + 4];      
	
	ncells = Problem.NCells;
	forcing = Problem.Field_forcing;			
	
	dnzm1 = Constants.dnzm1;
	dnym1 = Constants.dnym1;
	dnxm1 = Constants.dnxm1;
	c1 = Constants.c1;
	c2 = Constants.c2;
	dssp = Constants.dssp;
	tx2 = Constants.tx2;
	dx1tx1 = Constants.dx1tx1;
	dx2tx1 = Constants.dx2tx1;
    dx3tx1 = Constants.dx3tx1;
	dx5tx1 = Constants.dx5tx1;
	dx4tx1 = Constants.dx4tx1;
	xxcon1 = Constants.xxcon1;
	xxcon2 = Constants.xxcon2;
	xxcon3 = Constants.xxcon3;
	xxcon4 = Constants.xxcon4;
	xxcon5 = Constants.xxcon5;
	ty2 = Constants.ty2; 
    dy1ty1 = Constants.dy1ty1;
	yycon2 = Constants.yycon2;
	dy2ty1 = Constants.dy2ty1;
	yycon1 = Constants.yycon1;
	dy3ty1 = Constants.dy3ty1;
    dy4ty1 = Constants.dy4ty1;
	yycon3 = Constants.yycon3;
	yycon4 = Constants.yycon4;
	yycon5 = Constants.yycon5;
	dy5ty1 = Constants.dy5ty1;
	tz2 = Constants.tx2;
	dz1tz1 = Constants.dz1tz1;
	dz2tz1 = Constants.dz2tz1;
    dz3tz1 = Constants.dz3tz1;
	dz5tz1 = Constants.dz5tz1;
	dz4tz1 = Constants.dz4tz1;
	zzcon1 = Constants.zzcon1;
	zzcon2 = Constants.zzcon2;
	zzcon3 = Constants.zzcon3;
	zzcon4 = Constants.zzcon4;
	zzcon5 = Constants.zzcon5;
}
		
#endregion
		
private IBlocks blocks = null;

public IBlocks Blocks {
	get {
		if (this.blocks == null)
		{
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		}
		return this.blocks;
	}
}

private IProblemDefinition<I, C> problem = null;

public IProblemDefinition<I, C> Problem {
	get {
		if (this.problem == null) 
		{
			this.problem = (IProblemDefinition<I, C>) Services.getPort("problem_data");
		}
		return this.problem;
	}
}

private IExactSolution exact_solution = null;

protected IExactSolution Exact_solution {
	get {
		if (this.exact_solution == null)
			this.exact_solution = (IExactSolution) Services.getPort("exact_solution");
		return this.exact_solution;
	}
}


abstract public void compute(); 


}

}
