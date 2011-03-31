using System;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.data.ProblemDefinition { 
	public class Constants{	   
        public static double[,] ce = 
                                        {{   2.0d,    1.0d,    2.0d,    2.0d,    5.0d},
                                         {   0.0d,    0.0d,    2.0d,    2.0d,    4.0d},
                                         {   0.0d,    0.0d,    0.0d,    0.0d,    3.0d},
                                         {   4.0d,    0.0d,    0.0d,    0.0d,    2.0d},
                                         {   5.0d,    1.0d,    0.0d,    0.0d, 1.0E-01},
                                         {   3.0d,    2.0d,    2.0d,    2.0d, 4.0E-01},
                                         {5.0E-01,    3.0d,    3.0d,    3.0d, 3.0E-01},
                                         {2.0E-02, 1.0E-02, 4.0E-02, 3.0E-02, 5.0E-02},
                                         {1.0E-02, 3.0E-02, 3.0E-02, 5.0E-02, 4.0E-02},
                                         {3.0E-02, 2.0E-02, 5.0E-02, 4.0E-02, 3.0E-02},
                                         {5.0E-01, 4.0E-01, 3.0E-01, 2.0E-01, 1.0E-01},
                                         {4.0E-01, 3.0E-01, 5.0E-01, 1.0E-01, 3.0E-01},
                                         {3.0E-01, 5.0E-01, 4.0E-01, 3.0E-01, 2.0E-01}};
                                         
		public static void setConstants(int ij){
		   		   
		}
		public static double mod(double a, double b) { return (a % b); }
		public double min(int n1, int n2) { return n1 < n2 ? n1 : n2; }
		public double max(double n1, double n2) { return n1 > n2 ? n1 : n2; }
		public static double pow2(double p) { return p * p; }  
		public static int nodedim(double n) { return (int)(Math.Log(n) / Math.Log(2.0d) + 0.00001); }
        public static int ilog2(int i) {
            int log2, exp2 = 1;
            if(i <= 0) return (-1);
            for(log2 = 0; log2 < 20; log2++) {
                if(exp2 == i) return (log2);
                exp2 *= 2;
            }
            return (-1);
        }
        public static int ipow2(int i) {
            int pow2 = 1;
            if(i < 0) return (-1);
            if(i == 0) return (1);
            while(i-->0) pow2 *= 2;
            return (pow2);
        }
	}
   
   
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
		
        int itmax  {get;}
        int inorm  {get;}
        int isiz01 {get;}
        int isiz02 {get;}
        int isiz03 {get;}
        int isiz3  {get;}
		double dt  {get;}		
				
		bool[] icommn {get;}
		bool[] icomms {get;}
		bool[] icomme {get;}
		bool[] icommw {get;}
		int isiz1 {get;}
		int isiz2 {get;} 	
	}
}
