using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.data.ProblemDefinition { 
	public class Constants {
		public static int layout_0D = 0, layout_1D = 1, layout_2D = 2;
		public static int T_total = 1, T_setup = 2, T_fft = 3, T_evolve = 4, T_checksum = 5, T_fftlow = 6, 
		                          T_fftcopy = 7, T_transpose = 8, T_transxzloc = 9, T_transxzglo = 10, T_transxzfin = 11, 
		                          T_transxyloc = 12, T_transxyglo = 13, T_transxyfin = 14,  T_synch = 15, T_max = 15;
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
