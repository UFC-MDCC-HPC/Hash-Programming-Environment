using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using lu.LU;
using NPB3_0_JAV.BMInOut;

namespace impl.lu.LUImpl { 
	public class ILUImpl<C> : BaseILUImpl<C>, ILU<C>
	where C:IClass{
	   
        public int bid = -1;
		public static int num = 1;
    	public static String BMName = "LU";
		
		public BMResults results;

		public ILUImpl() { 
		
		} 
		
		private void runBenchmark(){
		    int node = worldcomm.Rank;
		    num = worldcomm.Size;
            if(node == 0) Console.WriteLine(" Size: " + isiz01 + " x " + isiz02 + " x " + isiz03);
            if(node == 0) Console.WriteLine(" Iterations: " + itmax);
            if(node == 0) Console.WriteLine(" Number of processes: " + num);
//            proc_grid();
//            neighbors();
//            subdomain();
//            setConstants();
            Process.configBlock();
            //---------------------------------------------------------------------
            //   set the boundary values for dependent variables
            //---------------------------------------------------------------------
            Setbv.compute();
            //---------------------------------------------------------------------
            //   set the initial values for dependent variables
            //---------------------------------------------------------------------
            Setiv.compute();
            //---------------------------------------------------------------------
            //   compute the forcing term based on prescribed exact solution
            //---------------------------------------------------------------------
            Erhs.compute();
            //---------------------------------------------------------------------
            //   perform one SSOR iteration to touch all data and program pages 
            //---------------------------------------------------------------------
            Ssor.setParameters(1);
            Ssor.compute();
            //---------------------------------------------------------------------
            //   reset the boundary and initial values
            //---------------------------------------------------------------------
            Setbv.compute();
            Setiv.compute();
            //---------------------------------------------------------------------
            //   perform the SSOR iterations
            //---------------------------------------------------------------------            
            Ssor.setParameters(itmax);
            Ssor.compute();
            double[] rsdnm  = Ssor.Rsdnm;
            //---------------------------------------------------------------------
            //   compute the solution error
            //---------------------------------------------------------------------            
            Error.compute();
            double[] errnm = Error.Errnm;
            //---------------------------------------------------------------------
            //   compute the surface integral
            //---------------------------------------------------------------------
            Pintgr.compute();
            double frc = Pintgr.Frc;
            //---------------------------------------------------------------------
            //   verification test
            //---------------------------------------------------------------------
            double maxtime = Ssor.Maxtime;
            if(node==0) {
                double mflops = ((double)(itmax))*(1984.77*((double)(nx0))*((double)(ny0))*((double)(nz0))-10923.3*pow2((((double)(nx0+ny0+nz0))/3.0))+27770.9*((double)(nx0+ny0+nz0))/3.0-144010.0) / (maxtime*1000000.0);
                Verify.setParameters(rsdnm, errnm, frc);
                Verify.compute();
                int verified = Verify.Verified;
                BMResults results = new BMResults(BMName,
                                        problem_class.ToString()[0],
                                        nx0,
                                        ny0,
                                        nz0,
                                        itmax,
                                        maxtime,
                                        mflops,
                                        "floating point",
                                        verified,
                                        true,
                                        num,
                                        -1);
                results.print();            
            }
            //mpi.Dispose();
		}
		
		public override void compute() { 
		   runBenchmark();
		}
		
		public static double pow2(double p) { return p * p; } 
	}
}
