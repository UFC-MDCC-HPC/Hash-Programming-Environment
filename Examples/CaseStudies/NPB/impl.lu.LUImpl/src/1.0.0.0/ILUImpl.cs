using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using lu.LU;
using NPB3_0_JAV.BMInOut;

namespace impl.lu.LU { 
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
            // Process.configBlock();
            
            //---------------------------------------------------------------------
            //   set the boundary values for dependent variables
            //---------------------------------------------------------------------
            Setbv.go();
            
            //---------------------------------------------------------------------
            //   set the initial values for dependent variables
            //---------------------------------------------------------------------
            Setiv.go();
            
            //---------------------------------------------------------------------
            //   compute the forcing term based on prescribed exact solution
            //---------------------------------------------------------------------
            Erhs.go();
            
            //---------------------------------------------------------------------
            //   perform one SSOR iteration to touch all data and program pages 
            //---------------------------------------------------------------------
            Ssor.setParameters(1);
            Ssor.go();
            
            //---------------------------------------------------------------------
            //   reset the boundary and initial values
            //---------------------------------------------------------------------
            Setbv.go();
            Setiv.go();
            
            //---------------------------------------------------------------------
            //   perform the SSOR iterations
            //---------------------------------------------------------------------            
            Ssor.setParameters(itmax);
            Ssor.go();
            double[] rsdnm  = Ssor.Rsdnm;
            
            //---------------------------------------------------------------------
            //   compute the solution error
            //---------------------------------------------------------------------            
            Error.go();
            double[] errnm = Error.Errnm;
            
            //---------------------------------------------------------------------
            //   compute the surface integral
            //---------------------------------------------------------------------
            Pintgr.go();
            double frc = Pintgr.Frc;
            
            //---------------------------------------------------------------------
            //   verification test
            //---------------------------------------------------------------------
            double maxtime = Ssor.Maxtime;
            
            if(node==0) 
            {
                double mflops = ((double)(itmax))*(1984.77*((double)(nx0))*((double)(ny0))*((double)(nz0))-10923.3*pow2((((double)(nx0+ny0+nz0))/3.0))+27770.9*((double)(nx0+ny0+nz0))/3.0-144010.0) / (maxtime*1000000.0);
                Verify.setParameters(rsdnm, errnm, frc);
                Verify.go();
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
		}
		
		public override int go() 
		{ 
		   runBenchmark();
		   return  0;
		}
		
		public static double pow2(double p) { return p * p; } 
	}
}
