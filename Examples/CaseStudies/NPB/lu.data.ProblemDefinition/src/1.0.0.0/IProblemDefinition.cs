using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.data.ProblemDefinition { 
	public interface IProblemDefinition<I, C> : BaseIProblemDefinition<I, C>
	where I:IInstance<C>
	where C:IClass {
		double [,,,] Field_a { get; }
		double [,,,] Field_b { get; }
		double [,,,] Field_c { get; }
		double [,,,] Field_d { get; }
				
		double [,,,] Field_u    { get; }
		double [,,,] Field_rsd  { get; }
		double [,,,] Field_frct { get; }
		double [,,,] Field_flux { get; }
		
		
		int node {get;}
		int ndim {get;}
		int num {get;}
		int xdim {get;}
		int ydim {get;}
		int row {get;}
		int col {get;}
		
		int nx0 {get;}
		int ny0 {get;}
		int nz0 {get;}
				
		bool[] icommn {get;}
		bool[] icomms {get;}
		bool[] icomme {get;}
		bool[] icommw {get;}
		int isiz1 {get;}
		int isiz2 {get;} 	
	}
}
