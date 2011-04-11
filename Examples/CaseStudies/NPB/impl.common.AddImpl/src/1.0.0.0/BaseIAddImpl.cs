/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.Add;
using common.problem_size.Class;
using common.problem_size.Instance;


namespace impl.common.AddImpl { 

	public abstract class BaseIAddImpl<I,C>: Computation, BaseIAdd<I,C>
			where I:IInstance<C>
			where C:IClass
	{
			
	#region data
			
	protected int ncells;
	protected double[,,,,] u;
	protected double[,,,,] rhs;
	protected int[,] start;
	protected int[,] end;
	protected int[,] cell_size;
			
	override public void initialize() 
	{
		start = Blocks.cell_start;
		end = Blocks.cell_end;
		cell_size = Blocks.cell_size;   
				
	    ncells = Problem.NCells;			
		u = Problem.Field_u;
		rhs = Problem.Field_rhs;
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
	
	private IProblemDefinition<I,C> problem = null;
	
	public IProblemDefinition<I,C> Problem {
		get {
			if (this.problem == null)
			{
			   this.problem = (IProblemDefinition<I,C>) Services.getPort("problem_data");					
			}
			return this.problem;
		}
	}
	
	
	abstract public int go(); 
	
	
	}

}
