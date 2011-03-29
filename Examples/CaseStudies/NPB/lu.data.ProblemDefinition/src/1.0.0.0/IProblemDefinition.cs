using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using lu.problem_size.Class;

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
		
		
		int node {get;set;}
		int ndim {get;set;}
		int num {get;set;}
		int xdim {get;set;}
		int ydim {get;set;}
		int row {get;set;}
		int col {get;set;}
		
		bool[] icommn {get;set;}
		bool[] icomms {get;set;}
		bool[] icomme {get;set;}
		bool[] icommw {get;set;}
		int isiz1 {get;set;}
		int isiz2 {get;set;} 
	}
}
