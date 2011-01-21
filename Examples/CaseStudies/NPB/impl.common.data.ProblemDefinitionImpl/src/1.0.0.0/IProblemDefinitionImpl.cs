using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.data.ProblemDefinition;

namespace impl.common.data.ProblemDefinition { 

public class IProblemDefinitionImpl : BaseIProblemDefinitionImpl, IProblemDefinition
{
		
	public char CLASS = 'S';

	protected int IMAX = 0, JMAX = 0, KMAX = 0, MAX_CELL_DIM = 0, BUF_SIZE = 0, IMAXP, JMAXP,
				  problem_size = 0, maxcells = 0, ncells = 0;
	protected int[] grid_points = { 0, 0, 0 };
	protected int niter_default = 0;
	protected double dt_default = 0.0d;		

	public void initialize_problem_data(char clss) 
	{			
		setProblemClass(clss);
		
		int total_nodes = this.Ranks.Length;
		maxcells =  Convert.ToInt32(Math.Sqrt(total_nodes));
			
        MAX_CELL_DIM = (problem_size/maxcells)+1;                
		IMAX = JMAX = KMAX = grid_points[0] = grid_points[1] = grid_points[2] = MAX_CELL_DIM;
        IMAXP = IMAX/2 * 2 + 1;
        JMAXP = JMAX/2 * 2 + 1;
        BUF_SIZE = MAX_CELL_DIM*MAX_CELL_DIM*(maxcells-1)*60*2+1;
		
		U.initialize_field("u",maxcells, KMAX+4,JMAXP+4,IMAXP+4, 5);
		Rhs.initialize_field("rhs", maxcells, KMAX+2,JMAXP+2,IMAXP+2, 5);
		Lhs.initialize_field("lhs", maxcells, KMAX+2,JMAXP+2,IMAXP+2, 15);
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
		
	private void setProblemClass(char clss) 
	{
		CLASS = clss;
        
		switch (clss)
		{
			case 'S':
                problem_size = 12;
				dt_default = .015d;
				niter_default = 100;
				break;
			case 'W':
				problem_size = 36;
				dt_default = .0015d;
				niter_default = 400;
				break;
			case 'A':
				problem_size = 64;
				dt_default = .0015d;
				niter_default = 400;
				break;
			case 'B':
				problem_size = 102;
				dt_default = .001d;
				niter_default = 400;
				break;
			case 'C':
				problem_size = 162;
				dt_default = .00067d;
				niter_default = 400;
				break;
            default :
                Console.WriteLine(": NO PROBLEM INSTANCE !!!");
				throw new Exception("NO PROBLEM INSTANCE");		                    
		}
	}
	
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

		
  public void initialize() 
  {
  }
		
  public void lhsinit() 
  {
  }
		
  public void exact_rhs()
  {
			
  }
					
			

}

}
