using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.data.ProblemDefinition { 
	public class Constants {
		public static int layout_0D = 0, layout_1D = 1, layout_2D = 2;
//		public static void set_constants(){
//		   
//		}
	}
	public interface IProblemDefinition<I, C> : BaseIProblemDefinition<I, C>
	where I:IInstance<C>
	where C:IClass {
		double [,,,] Field_u0     { get; }
		double [,,,] Field_u1     { get; }
		double [,,,] Field_u2     { get; }
				
		double[] twiddle { get; }
		double[,] u { get; }
		int[,] dims { get; }
		
		int np { get; set; }
		int np1 { get; set; }
		int np2 { get; set; }
		int layout_type { get; set; }
		int ntdivnp { get; set; }
		void problemConfig(int _np1, int _np2);
	}
}
