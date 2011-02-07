using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.data.ProblemDefinition;
using common.problem_size.Class;
using sp.problem_size.Instance_SP;

namespace impl.common.data.ProblemDefinition { 

public class IProblemDefinitionImpl<I, C> : BaseIProblemDefinitionImpl<I, C>, IProblemDefinition<I, C>
where I:IInstance_SP<C>
where C:IClass
{
		
	public IProblemDefinitionImpl()
	{
		initialize_problem_data();
		set_constants(0);
	}
		
	public char CLASS = 'S';
	
	protected int _IMAX_ = 0, _JMAX_ = 0, _KMAX_ = 0, _MAX_CELL_DIM_ = 0, BUF_SIZE = 0, IMAXP, JMAXP,
				  problem_size = 0, _maxcells_ = 0, ncells = 0;
	protected int[] _grid_points_ = { 0, 0, 0 };
	protected int niter_default = 0;
	protected double dt_default = 0.0d;		
	
	public int NCells { get { return ncells; } }
		
	public double [,,,,] Field_u       { get { return U.Field; } }	
	public double [,,,,] Field_rhs     { get { return Rhs.Field; } }	
	public double [,,,,] Field_lhs     { get { return Lhs.Field; } }	
	public double [,,,,] Field_forcing { get { return Forcing.Field; } }	
		
	public double [,,,,] Field_us       { get { return Us.Field; } }	
	public double [,,,,] Field_vs       { get { return Vs.Field; } }	
	public double [,,,,] Field_ws       { get { return Ws.Field; } }	
	public double [,,,,] Field_qs       { get { return Qs.Field; } }	
	public double [,,,,] Field_ainv     { get { return Ainv.Field; } }	
	public double [,,,,] Field_rho      { get { return Rho.Field; } }	
	public double [,,,,] Field_speed    { get { return Speed.Field; } }	
	public double [,,,,] Field_square   { get { return Square.Field; } }	
				
		
	public int MAX_CELL_DIM { get { return _MAX_CELL_DIM_; } set { _MAX_CELL_DIM_ = value; } }	
	public int maxcells { get { return _maxcells_; } set { _maxcells_ = value; }}	
	public int IMAX { get { return _IMAX_; } set { _IMAX_ = value; } }	
	public int JMAX { get { return _JMAX_; } set { _JMAX_ = value; } }	
	public int KMAX { get { return _KMAX_; } set { _KMAX_ = value; } }	
	public int[] grid_points { get { return _grid_points_; } }
		
	public void initialize_problem_data() 
	{			
		setProblemClass();
		
		int total_nodes = this.Ranks.Length;
		maxcells =  Convert.ToInt32(Math.Sqrt(total_nodes));
			
	    MAX_CELL_DIM = (problem_size/maxcells)+1;                
		IMAX = JMAX = KMAX = _grid_points_[0] = _grid_points_[1] = _grid_points_[2] = MAX_CELL_DIM;
	    IMAXP = IMAX/2 * 2 + 1;
	    JMAXP = JMAX/2 * 2 + 1;
			
		U.initialize_field("u", maxcells, KMAX+4, JMAXP+4, IMAXP+4, 5);
		Rhs.initialize_field("rhs", maxcells, KMAX+2, JMAXP+2, IMAXP+2, 5);
		Lhs.initialize_field("lhs", maxcells, KMAX+2, JMAXP+2, IMAXP+2, 15);
		Forcing.initialize_field("forcing", maxcells, KMAX+2, JMAXP+2, IMAXP+2, 5);
		
		Us.initialize_field("us", maxcells, KMAX+3, JMAX+3, IMAX+3);
		Vs.initialize_field("vs", maxcells, KMAX+3, JMAX+3, IMAX+3);
		Ws.initialize_field("ws", maxcells, KMAX+3, JMAX+3, IMAX+3);
		Qs.initialize_field("qs", maxcells, KMAX+3, JMAX+3, IMAX+3);
		Ainv.initialize_field("ainv", maxcells, KMAX+3, JMAX+3, IMAX+3);
		Rho.initialize_field("rho", maxcells, KMAX+3, JMAX+3, IMAX+3);
		Speed.initialize_field("speed", maxcells, KMAX+3, JMAX+3, IMAX+3);
		Square.initialize_field("square", maxcells, KMAX+3, JMAX+3, IMAX+3);			
	}
		
	private void setProblemClass() 
	{
        problem_size = Instance.problem_size;
		dt_default = Instance.dt_default;
		niter_default = Instance.niter_default;
	}	
	
  public void set_constants(int ndid)
  {			
	Constants.set_constants(ndid,grid_points);
  }
		
						
}

}
