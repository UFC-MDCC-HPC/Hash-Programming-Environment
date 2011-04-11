using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using lu.LU;

namespace impl.lu.LUImpl { 
	public class ILUImpl<C> : BaseILUImpl<C>, ILU<C>
	where C:IClass{
	
		public ILUImpl() { 
		
		} 
		
		private void runBenchmark(){
            if(node == 0) Console.WriteLine(" Size: " + isiz01 + " x " + isiz02 + " x " + isiz03);
            if(node == 0) Console.WriteLine(" Iterations: " + itmax);
            if(node == 0) Console.WriteLine(" Number of processes: " + num);
            proc_grid();
            neighbors();
            subdomain();
            setConstants();
            //---------------------------------------------------------------------
            //   set the boundary values for dependent variables
            //---------------------------------------------------------------------
            Setbv();
            //---------------------------------------------------------------------
            //   set the initial values for dependent variables
            //---------------------------------------------------------------------
            Setiv();
            //---------------------------------------------------------------------
            //   compute the forcing term based on prescribed exact solution
            //---------------------------------------------------------------------
            Erhs();
            //---------------------------------------------------------------------
            //   perform one SSOR iteration to touch all data and program pages 
            //---------------------------------------------------------------------
            Ssor(1);
            //---------------------------------------------------------------------
            //   reset the boundary and initial values
            //---------------------------------------------------------------------
            Setbv();
            Setiv();
            //---------------------------------------------------------------------
            //   perform the SSOR iterations
            //---------------------------------------------------------------------
            double[] rsdnm  = Ssor(itmax);
            //---------------------------------------------------------------------
            //   compute the solution error
            //---------------------------------------------------------------------
            double[] errnm = Error();
            //---------------------------------------------------------------------
            //   compute the surface integral
            //---------------------------------------------------------------------
            double frc = Pintgr();
            //---------------------------------------------------------------------
            //   verification test
            //---------------------------------------------------------------------
            if(node==0) {
                double mflops = ((double)(itmax))*(1984.77*((double)(nx0))*((double)(ny0))*((double)(nz0))-10923.3*pow2((((double)(nx0+ny0+nz0))/3.0))+27770.9*((double)(nx0+ny0+nz0))/3.0-144010.0) / (maxtime*1000000.0);
                int verified = Verify(rsdnm, errnm, frc);
                BMResults results = new BMResults(BMName,
                                        CLASS,
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
            mpi.Dispose();
		}
		
		public override void compute() { 
		   runBenchmark();
		}
	}
}
