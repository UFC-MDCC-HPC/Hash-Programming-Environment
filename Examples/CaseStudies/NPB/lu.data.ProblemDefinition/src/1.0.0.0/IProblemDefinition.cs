using System;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.data.ProblemDefinition { 
	public class Constants{	   
	    public static double dx1, dx2, dx3, dx4, dx5, dy1, dy2, dy3, dy4, dy5, dz1, dz2, dz3, dz4, dz5, dssp;
	    public static double dxi, deta, dzeta, tx1, tx2, tx3, ty1, ty2, ty3, tz1, tz2, tz3;
	    public static int ii1, ii2, ji1, ji2, ki1, ki2;
	    public static double c1=1.40d, c2=0.40d, c3=1.00E-01, c4=1.00d, c5=1.40d;
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
                                         
		public static void setConstants(int nx0, int ny0, int nz0){
            dxi   = 1.0d / (nx0 - 1);
            deta  = 1.0d / (ny0 - 1);
            dzeta = 1.0d / (nz0 - 1);

            tx1 = 1.0d/(dxi*dxi);
            tx2 = 1.0d/(2.0d*dxi);
            tx3 = 1.0d/dxi;

            ty1 = 1.0d/ (deta * deta);
            ty2 = 1.0d/ (2.0d* deta);
            ty3 = 1.0d/ deta;

            tz1 = 1.0d/ (dzeta * dzeta);
            tz2 = 1.0d/ (2.0d* dzeta);
            tz3 = 1.0d/ dzeta;

            ii1 = 2;
            ii2 = nx0 - 1;
            ji1 = 2;
            ji2 = ny0 - 2;
            ki1 = 3;
            ki2 = nz0 - 1;

            dx1 = 0.75d;
            dx2 = dx1;
            dx3 = dx1;
            dx4 = dx1;
            dx5 = dx1;

            dy1 = 0.75d;
            dy2 = dy1;
            dy3 = dy1;
            dy4 = dy1;
            dy5 = dy1;

            dz1 = 1.00d;
            dz2 = dz1;
            dz3 = dz1;
            dz4 = dz1;
            dz5 = dz1;
            dssp = (max(max(dx1, dy1), dz1))/4.0d;
		}
		public static double mod(double a, double b) { return (a % b); }
		public static double min(int n1, int n2) { return n1 < n2 ? n1 : n2; }
		public static double max(double n1, double n2) { return n1 > n2 ? n1 : n2; }
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
		
		
//		int node {get;}
//		int ndim {get;}
//		int num {get;}
//		int xdim {get;}
//		int ydim {get;}
//		int row {get;}
//		int col {get;}
		
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
				
//		bool[] icommn {get;}
//		bool[] icomms {get;}
//		bool[] icomme {get;}
//		bool[] icommw {get;}
		int isiz1 {get;}
		int isiz2 {get;} 	
	}
}
